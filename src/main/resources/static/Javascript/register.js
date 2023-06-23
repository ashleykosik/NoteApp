
//form, username, & password inputs/elements
const registerForm =  document.getElementById('register-form')
const registerUsername = document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')

const headers = {
'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

//function to handle submitting the form

async function handleSubmit(e) {
    e.preventDefault()

//body object with input values
    let body = {
        username: registerUsername.value,
        password: registerPassword.value
    }

//make request & handle response
    const response = await fetch(`${baseUrl}/register`, {
    method: "POST",
    body: JSON.stringify(body),
    headers: headers
    })
    .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)