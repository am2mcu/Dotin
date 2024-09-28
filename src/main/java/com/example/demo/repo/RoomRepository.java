package com.example.demo.repo;

import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.roomId = ?1")
    Optional<Room> findRoomById(Long roomId);

    @Query("SELECT r FROM Room r WHERE r.status = Available")
    List<Room> getAvailableRooms();

    @Query("SELECT r FROM Room r WHERE r.status = Reserved")
    List<Room> getReservedRooms();
}
