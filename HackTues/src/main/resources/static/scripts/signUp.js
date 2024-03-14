const Username = document.getElementsById("Username");
const Password = document.getElementsById("Password");
const Password2 = document.getElementsById("Password2");
let invalid = document.getElementById("Invalid");


addEventListener('submit', function(event) {
    event.preventDefault();

    const UsernameValue = Username.value;
    const PasswordValue = Password.value;
    const Password2Value = Password2.value;

    if (PasswordValue==null || PasswordValue2==null || Password2Value!=PasswordValue) {
    invalid.classList.remove('hidden');
    } 
    else {
        invalid.classList.add('hidden');
        
       
        const userData = {
            username: UsernameValue,
            password: PasswordValue
        };

        
        fetch('your_json_file_url_here', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Data posted successfully:', data);
        })
        .catch(error => {
            console.error('There was a problem posting the data:', error);
        });
    }
});
