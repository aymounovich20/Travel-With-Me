import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8085',
});

// Register a new user
export async function registerUser(userData) {
    try {
        const response = await instance.post('/api/users', userData);
        return response.data.user;
    } catch (error) {
        throw new Error('Failed to register user');
    }
}

// Login user
export async function loginUser(credentials) {
    try {
        const response = await instance.post('/api/users/login', credentials);
        console.log(response);
        return response.data;
    } catch (error) {
        throw new Error('Failed to login user');
    }
}
