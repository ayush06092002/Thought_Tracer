# Thought Tracer - Notes App

Thought Tracer is a simple notes app built with Kotlin for Android, allowing users to add, delete, and edit notes. It's designed to help users track their thoughts and ideas on the go.

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

## Contributing

Contributions are welcome! If you have any ideas for improvements, new features, or bug fixes, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

Special thanks to the following resources and communities:

- [Android Developers Documentation](https://developer.android.com/docs)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Room Persistence Library Documentation](https://developer.android.com/topic/libraries/architecture/room)
- [Hilt Documentation](https://developer.android.com/training/dependency-injection/hilt-android)
- [Coroutine Basics - Official Kotlin Documentation](https://kotlinlang.org/docs/coroutines-basics.html)
