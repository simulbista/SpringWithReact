import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Customers from "./pages/Customers";
import Products from "./pages/Products";
import Services from "./pages/Services";
import Vendors from "./pages/Vendors";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path={'/'} element={<Layout/>}>
                        {/*default route*/}
                        <Route index element={<Home/>}/>
                        {/*customers route*/}
                        <Route path={'customers'} element={<Customers/>}/>
                        {/*products route*/}
                        <Route path={'/products'} element={<Products/>}/>
                        {/*services route*/}
                        <Route path={'/services'} element={<Services/>}/>
                        {/*vendors route*/}
                        <Route path={'/vendors'} element={<Vendors/>}/>
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
