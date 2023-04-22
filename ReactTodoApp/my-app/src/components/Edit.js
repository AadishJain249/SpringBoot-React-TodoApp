import React, { useState ,useEffect} from 'react'
import DatePicker from 'react-datepicker';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import "react-datepicker/dist/react-datepicker.css";
function Edit() {
  const param=useParams();
  const [input,setInput]=useState([])
  useEffect(()=>{
  axios.get(`http://localhost:8081/getTask/${param.id}`).then(response=>{
      setInput(response.data) // setting responsing data
      console.log(response.data);

  }).catch((error)=>{
      console.log(error);
  })
},[])
  
const [startDate, setStartDate] = useState(new Date())
const handleChange = (e) =>
 {
  setInput((prevState) => 
  ({
    ...prevState,
    [e.target.name]: e.target.value,
  })
  );
};

const sendRequest = async () =>   
{
  const res = await axios
    .put(`http://localhost:8081/update/${param.id}`, 
    {
      name: input.name,
      desc: input.desc,
      aim:input.aim,
      done: input.done==="true"?true:false,
      date:startDate
    })
    .catch((err) => console.log(err));
    const data = await res.data;
    return data;
};
  const handleClick=(e)=>{
    e.preventDefault();
    sendRequest()
    .then((data) => console.log(data))
    .then(() => window.location='/get')
}
  return (
    <div className='container'>
    <h2>Add Todo</h2>
    <form>
      <div className='form-group'>
        <label>Name</label>
        <input 
        name="name"
        onChange={handleChange} 
        value={input.name}
        className='form-control' 
        autoComplete='off'
        placeholder="enter the username"></input>
      </div>
      <div className='form-group'>
        <label>Description Of Work</label>
        <input autoComplete='off' name="desc" className='form-control' value={input.desc} onChange={handleChange} type="text" placeholder="enter description" ></input>
      </div>
      <div className='form-group'>
        <label>Goal Of Work</label>
        <input autoComplete='off' name="aim" onChange={handleChange} value={input.aim} className='form-control' type="text" placeholder="Aim" ></input>
      </div>
      <div className='form-group'>
        <label>Done</label>
        {/* <input autoComplete='off' name="done" onChange={handleChange} value={input.done} className='form-control' type="text" placeholder="Done or Not Done" ></input> */}
        <h1>{input.done}</h1>
        <select value ={input.done} onChange={e=>setInput(e.target.value)}>
          <option>true</option>
          <option>false</option>
        </select>
       </div>
      <div className='form-group'>
          <label>Date</label>
          <div>
          <DatePicker   dateFormat="MM/dd/yyyy" autoComplete='off' selected={startDate} onChange={(date) => setStartDate(date)} />
          </div>
        </div>
        
      <div className="form-group">
        <input type="submit" onClick={handleClick} className="btn btn-primary" />
      </div>
    </form>
  </div>
)

}

export default Edit