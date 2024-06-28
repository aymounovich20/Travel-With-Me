import PropTypes from "prop-types";
import { FiMapPin } from "react-icons/fi";
import { Link } from "react-router-dom";

const Card = ({ trip }) => {
  const { name, destination, tripDays, cost, image, location, totalDays } =
    trip;
  return (
    <div
      style={{
        padding: "20px",
        backgroundColor: "#ffffff",
        borderRadius: "10px",
        boxShadow: "0px 2px 4px rgba(0, 0, 0, 0.1)",
      }}
    >
      <img
        style={{
          maxHeight: "250px",
          width: "100%",

          borderRadius: "10px",
          marginBottom: "10px",
        }}
        src={
          image
            ? image
            : `https://st2.depositphotos.com/2931363/5383/i/600/depositphotos_53837931-stock-photo-people-enjoying-road-trip.jpg`
        }
        alt={name}
      />
      <div
        style={{ display: "flex", alignItems: "center", marginBottom: "10px" }}
      >
        <FiMapPin style={{ fontSize: "18px", marginRight: "5px" }} />
        <span>{destination || location}</span>
      </div>
      <h2 style={{ fontWeight: "bold", marginBottom: "5px" }}>{name}</h2>
      <p style={{ color: "#888888" }}>
        {trip.startDate} | $ {cost}
      </p>
      <button>join</button>
    </div>
  );
};

Card.propTypes = {
  trip: PropTypes.shape({
    name: PropTypes.string.isRequired,
    destination: PropTypes.string,
    tripDays: PropTypes.number,
    cost: PropTypes.number.isRequired,
    image: PropTypes.string,
    location: PropTypes.string,
    totalDays: PropTypes.number,
  }),
};

export default Card;
const getUsert=() =>{
  return localStorage.getItem("user");
}