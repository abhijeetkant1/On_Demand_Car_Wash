import axios from "axios";

let car={
    name: "Riyan",
    username: "Ri123",
    email: "Riyan@gmail.com",
    contactno: 5636872824,
   password:"Riy123",
   confirmpassword:"Riy123"
}

test("Testing View All user funciton.", async () => {
    axios.get("http://localhost:8083/user/allusers").then((resp) =>{
        let user = result.data;
        expect(user).toBe(user);       
    });
});
test("Testing Add user funciton.", async () => {
    axios.post("http://localhost:8083/user/adduser",car).then((resp) =>{
        let carwash = result.data;
        expect(carwash).toBe(carwash);        
    });
});


