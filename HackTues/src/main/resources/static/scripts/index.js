function SignUpRedirect() {

    window.location.href = './templates/signUp.html';
  }
  

  function LogInRedirect() {

    window.location.href = '/templates/logIn.html';
  }
  

  document.getElementById('firstButton').onclick = SignUpRedirect;
  document.getElementById('secondButton').onclick = LogInRedirect;