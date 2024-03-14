const Username = document.getElementById("myUsername");
const Password = document.getElementById("myPassword");
const Password2 = document.getElementById("confirmPassword");
let invalid = document.getElementById("InvalidLogin");
const submitButton = document.querySelector('input[type="submit"]'); // Reference to the submit button

document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();

    animateSubmitButton(); // Call to animate the submit button on form submit

    const UsernameValue = Username.value.trim();
    const PasswordValue = Password.value.trim();
    const Password2Value = Password2.value.trim();

    if (!PasswordValue || !Password2Value || Password2Value !== PasswordValue) {
        invalid.classList.remove('hidden');
    } else {
        invalid.classList.add('hidden');

        const userData = {
            username: UsernameValue,
            password: PasswordValue
        };

        fetch('http://localhost:6969/api/hacktues/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Optionally, stop the animation or provide further user feedback here
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle errors or unsuccessful operations
        });
    }
});

