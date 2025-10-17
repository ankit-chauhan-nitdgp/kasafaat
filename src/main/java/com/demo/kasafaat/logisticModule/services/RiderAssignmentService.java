package com.demo.kasafaat.logisticModule.services;

import com.demo.kasafaat.commonModule.utils.GeoUtils;
import com.demo.kasafaat.logisticModule.dao.RiderRepository;
import com.demo.kasafaat.logisticModule.model.RiderModel;
import com.demo.kasafaat.logisticModule.model.RiderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderAssignmentService {

    private final RiderRepository repo;

    // this logic will be changed
    public RiderModel findNearestAvailableRider(double lat, double lon) {
        List<RiderModel> available = repo.findByStatus(RiderStatus.AVAILABLE);
        return available.stream()
            .min(Comparator.comparingDouble(a -> GeoUtils.distance(lat, lon, a.getCurrentLat(), a.getCurrentLon())))
            .orElseThrow(() -> new RuntimeException("No rider available"));
    }

    public void assignToDarkStore(Long riderId, Long darkStoreId) {
        RiderModel rider = repo.findById(riderId)
                .orElseThrow(() -> new RuntimeException("Rider not found"));
        rider.setAssignedDarkStoreId(darkStoreId);
        repo.save(rider);
    }
}
