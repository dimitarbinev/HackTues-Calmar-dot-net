function SignUpRedirect() {

    window.location.href = '../../resources/static/templates/signUp.html';
  }
  

  function LogInRedirect() {

    window.location.href = '../../resources/static/templates/logIn.html';
  }
  

  document.getElementById('firstButton').onclick = SignUpRedirect;
  document.getElementById('secondButton').onclick = LogInRedirect;