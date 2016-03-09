var fontcolor;

var data = [{
    Name: "St Patricks Day  Lunch",
    Date: "03/17/2016",
    Time: "12:00",
    Description: "On eve of St Patricks day there is lunch been provided to all the grad students",
    Location: "Lobby of engineering building.",
    category: "Food",
    Limit: 200
}, {
    Name: "Ester",
    Date: "03/27/2016",
    Time: "3:00",
    Location: "SantaClara Church",
    Description: "On eve of easter There is Lunch followed by egg hunt at Santaclara church",
    category: "Food",
    Limit: "unlimited"
}, {
    Name: "Spring clothes distribution",
    Date: "03/20/2016",
    Time: "4:00-7:00pm",
    Location: "lucas hall",
    Description: "As part of publicity for Startup(PinMe) opened by SCU students we have t-shirts of rage of sizes available with logo printed on then . Interested students can collect",
    category: "Clothing",
    Limit: "unlimited"
}, {
    Name: "St Patriks",
    Date: "03/17/2016",
    Time: "7:00-11:00Pm",
    Location: "sf union square",
    Description: "Irish community parade",
    category: "Recreation",
    Limit: "unlimited"
}, {
    Name: "county fair",
    Date: "03/26/2016",
    Time: "4:00-12:00pm",
    Location: "sanjose county park",
    Description: "County fair including rides and recreations for all age groups",
    category: "Recreation",
    Limit: "unlimited"
}, {
    Name: "Rockband Concert",
    Date: "04/14/2016",
    Time: "8:00-12:00 pm",
    Location: "sfo golden gate park",
    Description: "New brand named Rockzon about to have their first public show .",
    category: "Entertainment",
    Limit: 100
}, {
    Name: "Kuchipudi Arangetram",
    Date: "03/27/2016",
    Time: "4:00-6:00 pm",
    Location: "Liver more temple",
    Description: "On the event of Arangetram of Sri Student of Akella.Padmavati We cordially invite you to have an cultural feast by her performance.",
    category: "Entertainment",
    Limit: "unlimited"
},{
    Name: "St Patricks Day  Lunch",
    Date: "03/17/2016",
    Time: "12:00",
    Description: "On eve of St Patricks day there is lunch been provided to all the grad students",
    Location: "Lobby of engineering building.",
    category: "Food",
    Limit: 200
}, {
    Name: "Ester",
    Date: "03/27/2016",
    Time: "3:00",
    Location: "SantaClara Church",
    Description: "On eve of easter There is Lunch followed by egg hunt at Santaclara church",
    category: "Food",
    Limit: "unlimited"
}, {
    Name: "Spring clothes distribution",
    Date: "03/20/2016",
    Time: "4:00-7:00pm",
    Location: "lucas hall",
    Description: "As part of publicity for Startup(PinMe) opened by SCU students we have t-shirts of rage of sizes available with logo printed on then . Interested students can collect",
    category: "Clothing",
    Limit: "unlimited"
}, {
    Name: "St Patriks",
    Date: "03/17/2016",
    Time: "7:00-11:00Pm",
    Location: "sf union square",
    Description: "Irish community parade",
    category: "Recreation",
    Limit: "unlimited"
}, {
    Name: "county fair",
    Date: "03/26/2016",
    Time: "4:00-12:00pm",
    Location: "sanjose county park",
    Description: "County fair including rides and recreations for all age groups",
    category: "Recreation",
    Limit: "unlimited"
}, {
    Name: "Rockband Concert",
    Date: "04/14/2016",
    Time: "8:00-12:00 pm",
    Location: "sfo golden gate park",
    Description: "New brand named Rockzon about to have their first public show .",
    category: "Entertainment",
    Limit: 100
}, {
    Name: "Kuchipudi Arangetram",
    Date: "03/27/2016",
    Time: "4:00-6:00 pm",
    Location: "Liver more temple",
    Description: "On the event of Arangetram of Sri Student of Akella.Padmavati We cordially invite you to have an cultural feast by her performance.",
    category: "Entertainment",
    Limit: "unlimited"
}]

// function setFontcolor(color) {

//     var fontc = color.toLowerCase();
//     font = fontc.split("");
//     if (font[1] == 'f' || font[1] == 'e' || font[1] == 'd' || font[1] == 'c' || font[1] == 'b' || font[1] == 'a' || font[1] == 2) {
//         fontcolor = "black";
//     } else {
//         fontcolor = "white";
//     }
// }

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    // setFontcolor(color);
    return color;
}

function imagesid(data) {
    if (data.category.toLowerCase() == "food") {
        var number = Math.floor(Math.random() * 5);
    } else if (data.category.toLowerCase() == "entertainment") {
        var number = Math.floor((Math.random() * 4));
    } else if (data.category.toLowerCase() == "recreation") {
        var number = Math.floor(Math.random() * 3);
    } else {
        var number = Math.floor(Math.random() * 2);
    }
    return number;
}

function loadData() {

    for (var i = 0; i < data.length; i++) {
        var number = imagesid(data[i]);
       
        if(data[i].category == "Entertainment" ){
        	var imgsrc="e";
        }else{
        var imgsrc = data[i].category.toLowerCase();
        }
        var imgdata = imgsrc + number;
        var txt = '<li id="elem' + i + '"><img src="images/'+ imgdata +'.jpg" alt="image of"'+data[i].category+'">' + data[i].Name + '</li>';

        $('#couponlist').append(txt);
        $('#elem' + i).css("background","linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), "+ getRandomColor());
        $('#elem' + i).css("color", "white");
    }
}
$(document).ready(function(){
	loadData();	
});
