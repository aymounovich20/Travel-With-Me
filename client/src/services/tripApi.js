import axios from 'axios';

const instance = axios.create({
    baseURL: "http://localhost:8085",
});

//Create new trip
export async function createTrip(tripData,userId) {
    try {
        console.log("bbbb"+tripData);
        //const emailArray = trimStringToArray(tripData.invitations);
        //console.log("ccccc"+emailArray);
        const response = await instance.post(`/api/groups/createGroupByUserId/${userId}`, tripData);
        return response.data.trip;
    } catch (error) {
        alert("Failed to create trip");
        throw new Error('Failed to create trip');
    }
}

//Trip by id
export async function getTripById(tripId) {
    try {
        const response = await instance.get(`/api/groups/${tripId}`);
        return response.data;
    } catch (error) {
        alert("Failed to get trip");
        throw new Error('Failed to get trip');
    }
}

//Get user trips
export async function getUserTrips(userId) {
    try {
        const response = await instance.get(`/api/groups/allByUserId/${userId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        alert("Failed to get user trips");
        throw new Error('Failed to get user trips');
    }
}

//Delete trip
export async function deleteTrip(tripId) {
    try {
        const response = await instance.delete(`/api/trips/delete/${tripId}`);
        return response.data.trip;
    } catch (error) {
        alert("Failed to delete trip");
        throw new Error('Failed to delete trip');
    }
}

//Update trip
export async function updateTrip(tripId, tripData) {
    try {
        const response = await instance.put(`/api/trips/update/${tripId}`, tripData);
        return response.data.trip;
    } catch (error) {
        alert("Failed to update trip");
        throw new Error('Failed to update trip');
    }
}
export async function getAllTrips() {
    try {
        const response = await instance.get(`/api/groups`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        alert("Failed to get All trips");
        throw new Error('Failed to get All trips');
    }
}

const trimStringToArray = (str) => {
    // Split the string by commas and trim each resulting part
    return str.split(',').map(email => email.trim());
  };

