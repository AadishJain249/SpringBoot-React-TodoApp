import "bootstrap/dist/css/bootstrap.min.css";
import React from 'react'
// import {BrowserRouter as Router,Route, Routes} from "react-router-dom"
import {Routes,Route} from "react-router-dom"
import Navbar from './components/Navbar';
import CreateTodo from "./components/CreateTodo";
import TodoList from "./components/TodoList";
import Welcome from "./components/Welcome";
import Edit from "./components/Edit";
function App() {
  return (
    <React.Fragment>
      <Navbar></Navbar>
    <Routes>
      <Route path={'/edit/:id'} element={<Edit></Edit>}></Route>
      <Route path={'/get'} element={<TodoList/>}></Route>
      <Route path={'/create'} element={<CreateTodo></CreateTodo>}></Route>
      <Route path="*"  element={<Welcome></Welcome>}></Route>
    </Routes>     
    </React.Fragment>
  );
}
export default App;
