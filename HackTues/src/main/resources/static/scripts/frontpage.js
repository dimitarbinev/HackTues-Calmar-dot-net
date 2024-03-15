document.addEventListener('DOMContentLoaded', function () {
    document.querySelector('.hamburger').addEventListener('click', function () {
        var dropdown = document.getElementById('dropdownMenu');
        dropdown.classList.toggle('active');
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('gameSelectionForm'); // Ensure your form has this ID

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission

        // Collecting checkbox values
        const checkboxes = document.querySelectorAll('.game-checkbox:checked');
        let games = {};
        checkboxes.forEach((checkbox, index) => {
            
            games[`game${index + 1}`] = checkbox.value;
        });

        

        
        fetch('XXXXXXXXXXXXXX', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(games), 
        })
        .then(response => {
            if (response.ok) {
                return response.json(); 
            }
            else{
            throw new Error('Network response was not ok.');
            }
        })
        .then(data => {
            console.log('Response:', data); 
            window.location.href = "XXXXXXXXXXXXXXX"; 
        })
        .catch((error) => {
            console.error('Error:', error); 
        });
    });
});