package com.example.todolist.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.sqlitepackage.MyDbHandler;
import com.example.todolist.sqlitepackage.Task;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<Task> taskList;

    public RecyclerViewAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {
        final Task task = taskList.get(position);
        holder.taskName.setText(task.getName());
        holder.taskDescription.setText(task.getDescription());
        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation");
                builder.setMessage("Do you want to delete " + task.getName() + " ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MyDbHandler db = new MyDbHandler(context);
                        db.deleteTaskById(task.getId());
                        notifyItemRemoved(position);

                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView taskName;
        public TextView taskDescription;
        public ImageButton delete_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            taskName = itemView.findViewById(R.id.text_taskname);
            taskDescription = itemView.findViewById(R.id.text_taskdescription);
            delete_btn = itemView.findViewById(R.id.btn_delete);
        }

        @Override
        public void onClick(View view) {

            final int position = this.getAdapterPosition();
            final Task task = taskList.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mView = inflater.inflate(R.layout.cudialog, null);
            final EditText task_name = mView.findViewById(R.id.d_task);
            final EditText task_description = mView.findViewById(R.id.d_description);
            builder.setView(mView);
            builder.setCancelable(false);

            builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String name = task_name.getText().toString();
                    String description = task_description.getText().toString();

                    MyDbHandler db = new MyDbHandler(context);
                    task.setId(task.getId());
                    task.setName(name);
                    task.setDescription(description);

                    int affectedRows = db.updateTask(task);
                    notifyDataSetChanged();
                }
            });
            builder.setNegativeButton("Discard", null);
            builder.show();
        }

    }


}