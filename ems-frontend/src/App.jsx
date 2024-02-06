
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import EmployeeComponent from "./components/EmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import LIstEmployeeComponent from "./components/LIstEmployeeComponent";

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* //localhot:3000 */}
          <Route path="/" element={<LIstEmployeeComponent />}></Route>
          {/* //localhot:3000/employees */}
          <Route path="/employees" element={<LIstEmployeeComponent />}></Route>
          {/* //localhot:3000/add-employees */}
          <Route path="/add-employee" element={<EmployeeComponent />}></Route>
          {/* //localhot:3000/edit-employees/1 */}
          <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
