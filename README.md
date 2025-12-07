# Java Desktop Chat Application (Client–Server)

A simple yet functional Java Desktop Chat Application built using:

- Java Sockets (Networking)
- Java Swing (GUI)
- Multithreading
- MP3 sound notifications

This project demonstrates real-time communication between a Server and Client, running on the same machine or across devices on the same network.

---

🚀 Features

✅ Real-time Messaging  
Send and receive messages instantly using TCP sockets.

✅ Server + Client Architecture  
Run the `Server` first, then connect using the `Client`.

✅ GUI Built With Swing  
Simple and clean user interface for both Client and Server.

✅ Notification Sound  
Each new message plays a chat notification sound (`chat_sound.mp3`).

✅ Auto-scroll Chat Window  
Messages scroll automatically to the latest entry.

---

🗂️ Project Structure

ChatApplication/
│
├── client/
│ ├── Client.java
│ ├── ClientMain.java
│
├── server/
│ ├── Server.java
│ ├── ServerMain.java
│
├── sound/
│ └── chat_sound.mp3
│
└── README.md


---

🛠️ Technologies Used

- Java SE
- Swing (GUI)
- Sockets(Networking)
- I/O Streams
- Multithreading
- JLayer Library (for MP3 playback)

---

📥 How to Run

1️⃣ Start the Server

Run → ServerMain.java


You will see:


Server started
Waiting for client...
Your IP: xxx.xxx.xxx.xxx


2️⃣ Start the Client


Run → ClientMain.java

Enter the server's IP address.

If running on the same machine, use:


127.0.0.1


---

📸 Screenshots

- Client UI

  ![WhatsApp Image 2025-12-07 at 00 49 48_346bc2be](https://github.com/user-attachments/assets/fb1da8ff-e255-45df-8439-a5f733428707)

- Server UI

![WhatsApp Image 2025-12-07 at 00 52 04_eb7bc5b7](https://github.com/user-attachments/assets/34a69035-0221-4990-aa31-67d933df9c4b)




- Successful message exchange  

![WhatsApp Image 2025-12-07 at 00 53 32_0040723f](https://github.com/user-attachments/assets/0d5d8130-70f2-4d3e-b8dc-383e71fbd939)

![WhatsApp Image 2025-12-07 at 00 53 10_c203417d](https://github.com/user-attachments/assets/a8d14972-0597-433b-ba39-6583b5986ac6)

Future Enhancements (Planned)

These can be added easily:

- Multi-client group chat support  
- Better UI design with message bubbles  
- Encryption for secure communication  
- File sharing (Images, documents)  
- Chat history saved locally  
- Emojis support  
- Add typing indicator  

---

👤 Author

Prakhar Gupta   
Passionate about Java development, backend engineering, and real-time systems.

---

⭐ Contribute

Feel free to fork the repo, make improvements, and submit a pull request.

---

💙 Support

If you liked the project, please ⭐ star the repository!
