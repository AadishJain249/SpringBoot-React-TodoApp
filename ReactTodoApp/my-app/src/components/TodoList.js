import React,{useState,useEffect} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
function TodoList(props) {
 const [todo,todolist]=useState({todos:[]})
 useEffect(()=>{
    axios.get('http://localhost:8081/getTask').then(response=>{
        todolist({todos:response.data}) // setting responsing data
        console.log(response.data );

    }).catch((error)=>{
        console.log(error);
    })
 },[])
 const deletebyId=(id)=>
 {
    axios.delete("http://localhost:8081/delete/"+id).then(res=>{
        console.log(res.data);
    })
    todolist({todos:todo.todos.filter(ex=>ex._id!==id)})
 }
  return (
    <div className='container'>
    <h3>Todo List Item </h3>
    <table className="table">
      <thead className="thead-light">
        <tr>
          <th>UserName</th>
          <th>Description Of Work</th>
          <th>Goal To Achieve</th>
          <th>Goal Completed or Not</th>
          <th>Date</th>
          <th>Actions </th>
        </tr>
      </thead>
      <tbody>
      {
          todo.todos.map(ex=>
            <tr key={ex.id}>
            <td>{ex.name}</td>
            <td>{ex.desc}</td>
            <td>{ex.aim}</td>
            <td>{ex.done?"Achieved":"Not Achieved Yet"}</td>
            <>
            {console.log(ex.done)}
            </>
            <td>{ex.date}</td>
            <td>
              <Link to={"/edit/"+ex.id}>Edit</Link> | <a href='' onClick={()=>{deletebyId(ex.id)}}>Delete</a></td>
            </tr>
            )
          }
      </tbody>
    </table>
  </div>  
  )
}

export default TodoList