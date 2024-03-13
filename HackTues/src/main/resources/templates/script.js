const form = document.getElementById('myForm');
const input = document.getElementById('myUsername');
const password = document.getElementById('myPassword');


form.addEventListener('submit', function(event) {
  event.preventDefault();
  const inputValue = input.value;
  console.log(inputValue);
  const passwordValue = password.value
  console.log(passwordValue);
});