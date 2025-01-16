import React, { useEffect, useState } from 'react';
import { fetchProducts } from '../services/api';
import ProductCard from '../components/ProductCard';

const Products: React.FC = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const loadProducts = async () => {
            try {
                const data = await fetchProducts();
                setProducts(data);
            } catch (error) {
                console.error('Error fetching products:', error);
            }
        };
        loadProducts();
    }, []);

    const handleAddToCart = (productId: number) => {
        console.log(`Product ${productId} added to cart.`);
        // API-Aufruf zum Hinzufügen des Produkts in den Warenkorb
    };

    return (
        <div className="container mx-auto p-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
            {products.map((product: any) => (
                <ProductCard
                    key={product.id}
                    id={product.id}
                    name={product.name}
                    description={product.description}
                    price={product.price}
                    onAddToCart={handleAddToCart}
                />
            ))}
        </div>
    );
};

export default Products;
