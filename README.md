# 🧠 ASK.Oİ - AI Chatbot Application

**ASK.Oİ** is an AI-powered chatbot application built using **Java, Firebase, and OpenAI GPT-3.5 API**. This project allows users to chat with an AI assistant in **Turkish** and **English** while maintaining session persistence through Firebase Authentication.

## 🚀 Features

- **🔑 User Authentication**: Users can sign up and log in using Firebase.
- **🌐 Language Support**: Supports both **Turkish** and **English**.
- **💬 AI Chatbot**: Integrates with OpenAI GPT-3.5 API for intelligent responses.
- **📡 Cloud Data Storage**: User data is securely stored in **Firebase**.
- **📱 Mobile-Friendly UI**: Smooth user experience with intuitive interface design.

---

## 📂 Project Structure

```
ASK.Oİ/
│── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/askoi/
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── SignupActivity.java
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── ChatBotAPI.java
│   │   │   │   ├── MenuActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_login.xml
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_signup.xml
│   │   │   │   │   ├── activity_menu.xml
│   ├── build.gradle
│── README.md
│── LICENSE
```

---

## 📸 Screenshots

### 🔓 Login & Signup Page

- Users can **log in** or **sign up**.
- Firebase Authentication is used to store user information.
- The system automatically checks if the user is already logged in and redirects them accordingly.

### 🏠 Menu Activity

- After logging in, users can choose their preferred language (**Turkish or English**).
- A chatbot **logo** is displayed, symbolizing a friendly conversation experience.
- Clicking the logo starts a conversation with the chatbot.

### 💬 Main Chat Activity

- The main chat interface handles **user authentication, chat input, and API communication**.
- It consists of:
  - A **RecyclerView** to display chat messages.
  - An **EditText** input field for users to type messages.
  - A **Send Button** to send messages.
- Messages are processed via the **OpenAI API** and responses are displayed in real-time.

---

## 🔧 Technologies Used

- **Java** (Android Development)
- **Firebase Authentication & Realtime Database**
- **OpenAI GPT-3.5 API**
- **OkHttpClient** (For network requests)
- **RecyclerView & UI Components**

---

## 🔑 API Integration

### 📡 OpenAI API Key Configuration

The chatbot interacts with OpenAI's **GPT-3.5 model** through an API call. Below is a sample function:

```java
public void callChatAPI(String userInput) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://api.openai.com/v1/chat/completions")
        .header("Authorization", "Bearer YOUR_API_KEY")
        .post(RequestBody.create(
            MediaType.parse("application/json"),
            "{ "model": "gpt-3.5-turbo", "messages": [{"role": "user", "content": "" + userInput + "" }] }"
        ))
        .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            // Handle API response
        }

        @Override
        public void onFailure(Call call, IOException e) {
            // Handle API failure
        }
    });
}
```

> **⚠️ Note:** Replace `"YOUR_API_KEY"` with your actual OpenAI API key.

---

## 🛠 Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/ASK.Oİ.git
cd ASK.Oİ
```

### 2️⃣ Open in Android Studio

- Open **Android Studio** and select **"Open an existing project"**.
- Navigate to the cloned repository and select it.

### 3️⃣ Configure Firebase

1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Create a new project and enable **Authentication** & **Realtime Database**.
3. Download the `google-services.json` file and place it in `app/` directory.

### 4️⃣ Run the Application

- Connect your **Android emulator** or physical device.
- Click **Run ▶** in Android Studio.

---

## 🔌 Troubleshooting

### ❌ "API Request Failed"

- Ensure your **API key** is correctly set in the code.
- Check if OpenAI API is reachable from your device.

### 🔑 "Authentication Error"

- Make sure **Firebase Authentication** is properly set up.
- Verify that the `google-services.json` file is present.

---

## 🗑️ Cleanup

To remove all resources related to Firebase:

1. Go to **Firebase Console**, select your project, and **delete** it.
2. Remove API keys from the code to prevent misuse.
3. Delete the project directory:
   ```bash
   rm -rf ASK.Oİ
   ```

---

## 🔥 Firebase Configuration

Your Firebase `google-services.json` file should contain a section like this:

```json
{
  "project_info": {
    "project_number": "85388196896",
    "project_id": "ask-oi",
    "storage_bucket": "ask-oi.appspot.com"
  },
  "client": [
    {
      "client_info": {
        "mobilesdk_app_id": "1:85388196896:android:7c3610057e952ba8015045",
        "android_client_info": {
          "package_name": "com.example.easychatgpt"
        }
      },
      "oauth_client": [],
      "api_key": [
        {
          "current_key": "YOUR_FIREBASE_CURRENT_KEY"
        }
      ],
      "services": {
        "appinvite_service": {
          "other_platform_oauth_client": []
        }
      }
    }
  ],
  "configuration_version": "1"
}
```

> **⚠️ Note:** `"YOUR_FIREBASE_CURRENT_KEY"` with your actual Firebase API key.

This method helps keep your API keys secure and prevents them from being exposed in the source code.

> **❗ Note:** If you're using an Android project, consider using **BuildConfig** to pass environment variables securely.

---

## 📜 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## ✨ Contributors

- **İbrahim Halil Demircioğlu** - [GitHub](https://github.com/H4LL1L)

---
