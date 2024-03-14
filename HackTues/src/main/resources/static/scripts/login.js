const form = document.getElementById('myForm');
const input = document.getElementById('myUsername');
const password = document.getElementById('myPassword');
let loginInvalid = document.getElementById('InvalidLogin');

form.addEventListener('submit', function(event) {
  event.preventDefault();

  
  const data = {
    username: input.value,
    password: password.value,
  };
  fetch('http://localhost:6969/api/hacktues/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    console.log('Success:', data);
    if (data=='OK'){
        console.log(data);
        //window.location.href = '/api/hacktues/login';
    loginInvalid.classList.add('hidden');
    }
    else{
    loginInvalid.classList.remove('hidden');
    }

  })
  .catch((error) => {
    console.error('Error:', error);
    
    loginInvalid.classList.remove('hidden');
  });
});