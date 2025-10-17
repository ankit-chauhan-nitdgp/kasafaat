package com.demo.kasafaat.darkstoreModule.services;

import com.demo.kasafaat.commonModule.utils.GeoUtils;
import com.demo.kasafaat.darkstoreModule.dao.DarkStoreRepository;
import com.demo.kasafaat.darkstoreModule.model.DarkStoreModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DarkStoreService {
    private final DarkStoreRepository repo;

    public DarkStoreModel findNearest(double userLat, double userLon) {
        List<DarkStoreModel> all = repo.findByActiveTrue();
        return all.stream()
                .min(Comparator.comparingDouble(a ->
                        GeoUtils.distance(userLat, userLon, a.getLat(), a.getLon())))
                .orElseThrow(() -> new RuntimeException("No active darkStore found"));
    }
}
