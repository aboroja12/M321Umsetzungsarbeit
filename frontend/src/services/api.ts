import axios from 'axios';

// Basis-URL für die API (API Gateway oder direkt zu Microservices)
const API_BASE_URL = 'http://localhost:8080'; // Beispiel: API Gateway

// Erstellt eine Instanz von Axios mit vorkonfigurierten Einstellungen
const apiClient = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// API-Funktionen für verschiedene Endpunkte
export const fetchProducts = async () => {
    const response = await apiClient.get('/products');
    return response.data;
};

export const fetchProductById = async (id: number) => {
    const response = await apiClient.get(`/products/${id}`);
    return response.data;
};

export const addProductToCart = async (productId: number, quantity: number) => {
    const response = await apiClient.post('/cart', {
        productId,
        quantity,
    });
    return response.data;
};

export const fetchCartItems = async () => {
    const response = await apiClient.get('/cart');
    return response.data;
};

export const placeOrder = async (orderData: any) => {
    const response = await apiClient.post('/orders', orderData);
    return response.data;
};

// Exporte für Axios-Instanz (optional, falls Anpassungen nötig sind)
export default apiClient;
