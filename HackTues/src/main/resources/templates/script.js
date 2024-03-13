const form = document.getElementById('myForm');
const input = document.getElementById('myUsername');
const password = document.getElementById('myPassword');


form.addEventListener('submit', function(event) {
  event.preventDefault();
  const inputValue = input.value;
  console.log(inputValue);
  const passwordValue = password.value
  console.log(passwordValue);

  fetch('http://localhost:6969/api/hacktues', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
  });
});


