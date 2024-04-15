import React from 'react';
import {Link, Outlet} from "react-router-dom";

const Layout = () =>{
    return(
        <>
            <header>
                <h1>
                    <Link to={'/'} className={'header-link'}>Wisdom Pet</Link>&nbsp;
                    <Link to={'/customers'} className={'header-link'}>Customers</Link>&nbsp;
                    <Link to={'/products'} className={'header-link'}>Products</Link>&nbsp;
                    <Link to={'/vendors'} className={'header-link'}>Vendors</Link>&nbsp;
                    <Link to={'/services'} className={'header-link'}>Services</Link>&nbsp;
                </h1>
            </header>
            <main>
                <Outlet/>
            </main>
        </>
    )
};

export default Layout;
