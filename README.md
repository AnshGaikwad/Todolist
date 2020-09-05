# Todolist
This application is a short implementation of using crud in [sqlite](https://developer.android.com/reference/android/database/sqlite/package-summary), using [shared preferances](https://developer.android.com/reference/android/content/SharedPreferences) for saving small tasks and saving tasks as a .txt file in the internal storage. I haven't focussed on the layouts and ui at all but it is clean and easy to use. 
# Installation
Run the command in your terminal
```
git clone https://github.com/AnshGaikwad/Todolist.git
```
Or you can just clone it through [android studio](https://developer.android.com/studio) which will be much easier.
# Small Description
### SQLite 
I have implemented all Create, Read, Update and Delete. Users can add task by creating it, update it if they have made a mistake or they can also delete it completely. I have used a list view to display all saved task in the database.
### Shared Preferances
After typing the task and then clicking the enter task button, it gets stored somewhere in the application data and even though we close the app and reopen it, the task is as it was before.
### Internal Storage
After typing the task and clicking the save task button, the task gets saved in the internal storage as a .txt file and after you close the app and reopen it, just hit the load saved task button and the task will be retrieved from the internal storage and then displayed in the edit text section.
