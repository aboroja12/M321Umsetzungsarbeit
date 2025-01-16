import React from 'react';
import { Link } from 'react-router-dom';

const Header: React.FC = () => {
    return (
        <header className="bg-blue-600 text-white p-4">
            <div className="container mx-auto flex justify-between items-center">
                <h1 className="text-lg font-bold">Shop</h1>
                <nav>
                    <Link to="/" className="mr-4">Home</Link>
                    <Link to="/products" className="mr-4">Products</Link>
                    <Link to="/cart">Cart</Link>
                </nav>
            </div>
        </header>
    );
};

export default Header;
