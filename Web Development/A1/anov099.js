function getVersion() {
    const xhr = new XMLHttpRequest();
    const uri = "http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/version";
    xhr.open("GET", uri, true);
    xhr.onload = function () {
       const version_d = document.getElementById("version");
       version_d.innerHTML = "© Arty, version is " + xhr.responseText;
    }
    xhr.send(null);
 }

 function getNews() {
    const uri = "http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/news";
    const xhr = new XMLHttpRequest();
    xhr.open("GET", uri, true);
    xhr.setRequestHeader("Accept","Application/json")
    xhr.onload = () => {
       const resp = JSON.parse(xhr.responseText);
       showNews(resp);
    }
    xhr.send(null);
 }

 function showNews(destinations) {
    for (let i = 0; i < destinations.length; i++){
        const list = destinations[i];
        const title = list.titleField;
        const date = list.pubDateField;
        const description = list.descriptionField;
        const picture = '<img src="' + list.enclosureField.urlField+ '" width="50%" height="50%">';
        let passPage =  '<h1 id="newsHeader">'+ title + "</h1>" + '<h2 id="newsDate">' + date + "</h2>" + '<p id="newsParagraph">' + description + "</p>" + "<br/><br/>" + picture + "<br/><br/><br/>" ;
        if (i != destinations.length - 1){
            passPage += "<hr width=90% size=5px color=#bc6596 radius=5px>" + "<br/>";
        }
        document.getElementById("News").innerHTML += passPage;
        
    }
 }

function showHomeTab() {
    if(currentTab != "HomeTab"){
        currentTab = "HomeTab";
        showNoTabs();
        document.getElementById("HomeTab").style.backgroundColor = "#9dd3f7";
        document.getElementById("HomePage").style.display = "inline";
    }
}

function getDisplays(){
    const url = "http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/items";
    const xhr1 = new XMLHttpRequest();
    xhr1.open("GET", url, true);
    xhr1.setRequestHeader("Accept","Application/json")
    xhr1.onload = () => {
       const items = JSON.parse(xhr1.responseText);
       searchShowDisplays(items);
    }
    xhr1.send(null);
}

function searchGetDisplay(){
    const term = document.getElementById("myInput").value;
    const searchurl = `http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/search?term=${term}`;
    const xhr1 = new XMLHttpRequest();
    xhr1.open("GET", searchurl, true);
    xhr1.setRequestHeader("Accept","Application/json")
    xhr1.onload = () => {
       const items = JSON.parse(xhr1.responseText);
       searchShowDisplays(items);
    }
    xhr1.send(null);
}

function searchShowDisplays(items){
    console.log(items);
    let newstring = '';
    for (let i = 0; i < items.length; i++){
        const list1 = items[i];
        const description1 = list1.Description;
        const displayPicture =  '<img src="http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/itemimg?id=' + list1.ItemId +'" width="50%" height="50%">';
        const title1 = list1.Title;
        let passPage1 =  '<h1 id="displayHeader">'+title1+"</h1>" + '<p id="newsParagraph">' + description1 + "</p>" + "</br></br>" + displayPicture + "</br></br>";
        if (i != items.length - 1){
            passPage1 += "<hr width=90% size=5px color=#bc6596 radius=5px>";
        }
        newstring += passPage1;
    }
    document.getElementById("Displaying").innerHTML = newstring;
}

function postComments(){
    const name = document.getElementById("name").value;
    const nameurl = `http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/comment?name=${name}`;
    const comment = document.getElementById("comment").value;
    const xhr = new XMLHttpRequest();
    xhr.open("POST",nameurl,true);
    let jsoncomment = JSON.stringify(comment);
    xhr.setRequestHeader("Content-Type","Application/json");
    xhr.send(jsoncomment);
    xhr.onload = () => {
        document.getElementById("frame").src="http://redsox.uoa.auckland.ac.nz/ms/MuseumService.svc/htmlcomments";
     }

}


 window.onload = function () {
     getVersion();
     showHomeTab();
     getNews();
     getDisplays();
 }