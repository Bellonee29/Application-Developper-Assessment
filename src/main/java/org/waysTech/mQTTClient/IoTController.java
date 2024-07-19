package org.waysTech.mQTTClient;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/iot")
public class IoTController {

    @Autowired
    private IoTDataService iotDataService;

    @GetMapping("/{deviceId}")
    public ResponseEntity<List<IoTData>> getDeviceData(@PathVariable String deviceId) {
        return ResponseEntity.ok(iotDataService.getDataByDeviceId(deviceId));
    }

    @PostMapping
    public ResponseEntity<IoTData> createData(@RequestBody IoTData data) {
        return ResponseEntity.ok(iotDataService.saveData(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        iotDataService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}