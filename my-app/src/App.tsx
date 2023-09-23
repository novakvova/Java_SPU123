import './App.css'
import {Route, Routes} from "react-router-dom";
import DefaultLayout from "./components/containers/default/DefaultLayout.tsx";
import CategoryListPage from "./components/admin/category/list/CategoryListPage.tsx";
import CategoryCreatePage from "./components/admin/category/create/CategoryCreatePage.tsx";
import LoginPage from "./components/auth/login/LoginPage.tsx";
import HomePage from "./components/home/HomePage.tsx";
function App() {

  return (
    <>
        <Routes>
            <Route path={"/"} element={<DefaultLayout/>}>
                <Route index element={<HomePage/>}/>
                <Route path={"login"} element={<LoginPage/>}/>
            </Route>
            <Route path={"/admin"} element={<DefaultLayout/>}>
                <Route path={"category"}>
                    <Route path={"list"} element={<CategoryListPage/>}/>
                    <Route path={"create"} element={<CategoryCreatePage/>}/>
                </Route>
            </Route>
        </Routes>
    </>
  )
}

export default App
