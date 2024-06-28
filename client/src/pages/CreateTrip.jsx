import { TripForm } from "../components";

const CreateTrip = () => {
  return (
    <div
      className="container"
      style={{
        padding: "3rem 2rem",
        gap: "2rem",
      }}
    >
      <div className="inner-container">
        <h1>Create a New Travel Group</h1>
        <p>Plan your next adventure with our Group travel App.</p>
      </div>
      <TripForm />
    </div>
  );
};

export default CreateTrip;
