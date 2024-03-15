document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.games-list');
    
    
    fetch('/api/hacktues/gettags')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.text(); // First get the response text
    })
    .then(text => {
      console.log(text); // Log the raw text
      return JSON.parse(text); // Manually parse the text as JSON
    })
    .then(data => {
      console.log(data); // Log the data
    })
    .catch(error => {
      console.error('There was a problem with your fetch operation:', error);
    });


    form.addEventListener('submit', function(event) {
        // Prevent the form from submitting the traditional way
        event.preventDefault();

        // Gather the data from the form
        const formData = new FormData(form);
        const data = {};
        formData.forEach((key) => {
            const checkboxes = document.getElementsByName(key);
            if (checkboxes.length == 0) {
                return;
            }

            const isChecked = checkboxes[0].checked;
            data[key] = isChecked;
        });

        // Convert the JavaScript object to JSON
        const jsonData = JSON.stringify(data);

        // Send the JSON data to the server
        fetch('/api/hacktues/updatedata', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: jsonData,
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
        })
        .then(data => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });






});