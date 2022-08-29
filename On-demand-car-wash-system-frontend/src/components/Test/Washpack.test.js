import axios from "axios";

let edu={
    id:2,
      packname: "Wash9",
      cost:500,
      description:"Full car wash"
}



test("Testing Add washpack funciton.", async () => {
    axios.post("http://localhost:8084/admin/addwashpack", edu).then((resp) =>{
        let pack = result.data;
        expect(pack).toBe({name: "hello"});        
    });
});

test("Testing View all washpack funciton.", async () => {
    axios.get("http://localhost:8084/admin/washpack").then((resp) =>   {
        let pack = result.data;
        expect(pack).toBe(pack);        
    });
});


