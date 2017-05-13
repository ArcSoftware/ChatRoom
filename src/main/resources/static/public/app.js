// 3

function showMessages(message) {

  // this is where we will create/append the users ------------------
  let base = document.querySelector('.message-container');
  let eachUser = document.createElement('li');
  eachUser.textContent = message.from;
  base.appendChild(eachUser);

  // this is where we will create/append the timestamp ------------------
  let eachTime = document.createElement('span');
  eachTime.textContent = ' on ' + message.added.slice(0, 21);
  eachUser.appendChild(eachTime);

  // this is where we will create/append the actual messages ------------------
  let eachMessage = document.createElement('li');
  eachMessage.textContent = message.message;
  eachUser.appendChild(eachMessage);
}

// 2
function getMessages(i) {
  // goal of this function is to get the message data stored in a variable through a GET request

  // create a variable, 'req', representing a new XMLHttpRequest
  let request = new XMLHttpRequest();

  // using GET, access data from this URL
  request.open('GET', '192.168.1.6:8080/get-messages'); 
  // add-message

  // wait for the GET request to finish
  request.addEventListener('load', function () {

    // new variable, 'rawData', set = to the JSON parsed values
    let rawData = JSON.parse(request.responseText);
    console.log(rawData);

    // for each instance of message in rawData, call the showMessages function (at top)
    for (let i = 0; i < rawData.chats.length; i++) {
      showMessages(rawData.chats[i]);
      console.log(i);
    }

  }); //close event listener
  request.send();
};

// 1
window.addEventListener('load', function () {

  console.log('page loaded');

  // once the page loads, pull message data  

  // select the sendMessage button
  let sendMessageBtn = document.querySelector('#submit');

  sendMessageBtn.addEventListener('click', function () {
    //store the value of the message typed
    let message = document.querySelector('#message');

    //new POST request
    let request = new XMLHttpRequest();
    request.open('POST', '192.168.1.6:8080/add-messages'); 
    //     
    request.addEventListener('load', function () {
      console.log('received response');
    });

    request.send(JSON.stringify({
      // from: username.value,
      message: message.value,
    }));

    // clear the message field on submit
    message.value = '';


  }); // close userInput event listener




  setInterval(function () {

    let children = document.querySelector('.message-container').childElementCount;
    console.log(children);
    // goal of this function is to get NEW messages

    // create a variable, 'req', representing a new XMLHttpRequest
    let request = new XMLHttpRequest();

    // using GET, access data from this URL
    request.open('GET', '192.168.1.6:8080/get-messages');

    // wait for the GET request to finish
    request.addEventListener('load', function () {

      // new variable, 'rawData', set = to the JSON parsed values
      let rawData = JSON.parse(request.responseText);
      console.log(rawData);

      // for each instance of message in rawData, call the showMessages function (at top)
      for (let i = children; i < rawData.chats.length; i++) {
        showMessages(rawData.chats[children]);
        console.log(i);
      }

    }); //close event listener
    request.send();


  }, 500);

  getMessages();

});