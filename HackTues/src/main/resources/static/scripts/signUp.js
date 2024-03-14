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


})
