# Thought Tracer - Notes App

Thought Tracer is a simple notes app built with Kotlin for Android, allowing users to add, delete, and edit notes. It's designed to help users track their thoughts and ideas on the go.

<img src = "https://github.com/ayush06092002/Thought_Tracer/assets/22142132/4e13a345-8138-4923-875b-26a3680d9f05" width="250" height="555.56" />
<img src = "https://github.com/ayush06092002/Thought_Tracer/assets/22142132/cc0de9aa-fd66-4bdc-bb15-4cebb1e6006f" width="250" height="555.56" />

## Features

1. **Add Note**: Quickly add new notes to capture your thoughts.
2. **Delete Note**: Remove unwanted notes with a single tap.
3. **Edit Note**: Modify existing notes to update your thoughts.

## Technologies Used

Thought Tracer leverages the following technologies and concepts:

- **LazyStaggeredView**: Utilized for displaying notes in a staggered layout, providing an organized view for users.
- **Dependency Injection using Hilt**: Employed Hilt for dependency injection to streamline app development and manage dependencies effectively.
- **View Model**: Utilized ViewModel to manage UI-related data in a lifecycle-conscious way, separating UI logic from the UI controller.
- **Persisting Data - Room Database**: Integrated Room Database to persist notes locally, ensuring data is preserved across app sessions.
- **Coroutines and Suspend Functions**: Leveraged Coroutines for asynchronous and non-blocking programming, enhancing app responsiveness and performance.
- **Dispatchers**: Utilized Dispatchers to manage the execution context of coroutines, ensuring proper thread handling and concurrency.

## Getting Started

To get started with Thought Tracer, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.
4. Explore the features and start tracking your thoughts!
5. Or you can simply install the apk in the repo.


## Acknowledgements

Special thanks to the following resources and communities:

- [Android Developers Documentation](https://developer.android.com/docs)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Room Persistence Library Documentation](https://developer.android.com/topic/libraries/architecture/room)
- [Hilt Documentation](https://developer.android.com/training/dependency-injection/hilt-android)
- [Coroutine Basics - Official Kotlin Documentation](https://kotlinlang.org/docs/coroutines-basics.html)
