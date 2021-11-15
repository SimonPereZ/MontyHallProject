import axios from "axios";

export default async function useBackendSimulator(numberOfAttempts, changeDoor) {

    const payload = {
        numberOfAttempts: numberOfAttempts,
        changeDoor: changeDoor
    }
    return axios.post(`start`, payload)
        .then(res => res.data)
        .catch(res => {
            console.log(res);
        });



}
