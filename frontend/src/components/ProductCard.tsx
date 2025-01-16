import React from 'react';

interface ProductCardProps {
    id: number;
    name: string;
    description: string;
    price: number;
    onAddToCart: (productId: number) => void;
}

const ProductCard: React.FC<ProductCardProps> = ({ id, name, description, price, onAddToCart }) => {
    return (
        <div className="border border-gray-300 rounded-lg shadow-md p-4 hover:shadow-lg">
            <h2 className="text-lg font-bold">{name}</h2>
            <p className="text-sm text-gray-600">{description}</p>
            <p className="text-lg font-semibold mt-2">${price.toFixed(2)}</p>
            <button
                onClick={() => onAddToCart(id)}
                className="mt-4 bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
            >
                Add to Cart
            </button>
        </div>
    );
};

export default ProductCard;
