import { useSelector } from "react-redux";
import { useEffect, useState } from "react";

import { getAllTrips } from "../services/tripApi";
import { Card } from "../components";
import { Link } from "react-router-dom";

const AllGroups = () => {

  const [trips, setTrips] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [searchTerm, setSearchTerm] = useState("");
  const [filteredTrips, setFilteredTrips] = useState([]);

  useEffect(() => {
    setIsLoading(true);

    // Fetch user trips from the server
    getAllTrips()
      .then((trips) => {
        setTrips(trips);
        setIsLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching trips:", error);
        setIsLoading(false);
      });
  }, []);

  useEffect(() => {
    // Filter trips based on search term
    const filtered = trips.filter((trip) =>
      trip.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    setFilteredTrips(filtered);
  }, [trips, searchTerm]);

  const [activeTab, setActiveTab] = useState("trips");

  const handleTabChange = (tab) => {
    setActiveTab(tab);
  };

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };


  return (
    <div
      className="container"
      style={{
        padding: "2rem",
      }}
    >
      <div
        className="inner-container"
        style={{
          width: "100%",
          padding: "2rem 5rem",
          gap: "2rem",
        }}
      >
        <div className="row" style={{ width: "100%" }}>
          <div
            className="row"
            style={{
              gap: "0.5rem",
            }}
          >
            <button
              className={`tab ${activeTab === "trips" ? "active" : ""}`}
              onClick={() => handleTabChange("trips")}
            >
              All Trips
            </button>
          </div>

          <div>
            {/* Search bar */}
            <input
              type="text"
              placeholder="Search"
              value={searchTerm}
              onChange={handleSearch}
            />
          </div>
        </div>

        <div
          style={{
            width: "100%",
          }}
        >
          {/* Render content based on active tab */}
          {activeTab === "trips" && (
            <div
              key={filteredTrips.length}
              style={{
                width: "100%",
                display: "grid",
                gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
                gridGap: "2rem",
              }}
            >
              {/* Render filtered trips */}
              {
                // If loading, show loading message
                isLoading ? (
                  <p
                    className="row"
                    style={{
                      width: "100%",
                      justifyContent: "center",
                      alignItems: "center",
                      marginTop: "2rem",
                      color:"blue"
                    }}
                  >
                    Loading trips...
                  </p>
                ) : // If no trips, show no trips message
                filteredTrips.length === 0 ? (
                  <div
                    className="inner-container"
                    style={{
                      width: "100%",
                      justifyContent: "center",
                      alignItems: "center",
                      marginTop: "2rem",
                    }}
                  >
                    <h2>No Trips Found</h2>
                    <Link to="/create-trip" className="button">
                      Create a Trip
                    </Link>
                  </div>
                ) : (
                  // Else, render trips

                  filteredTrips.map((trip) => (
                    <Link key={trip.id} to={`/trips/${trip.groupId}`}>
                      <Card trip={trip} />
                    </Link>
                  ))
                )
              }
            </div>
          )}
        </div>
      </div>
    </div>
  );
};
export default AllGroups;