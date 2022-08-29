import axios from "axios";

let car={
    id:2,
    name:"Abhijeet",
    location:"Banglore"
}




test("Testing View all washers funciton.", async () => {
    axios.get("http://localhost:8087/admin/allwasher").then((resp) =>   {
        let pack = result.data;
        expect(pack).toBe(pack);        
    });
});
test("Testing View washer By Id funciton.", async () => {
    axios.get("http://localhost:8082/washer/viewWasher/" + 301).then((resp) =>  {
        let education = result.data;
        expect(education).toBe(education);        
    });
});

test("Testing Update washer funciton.", async () => {
    axios.put("http://localhost:8082/washer/account/update", car).then(resp =>{
        let carwash = result.data;
        expect(carwash).toBe(carwash);        
    });
});

