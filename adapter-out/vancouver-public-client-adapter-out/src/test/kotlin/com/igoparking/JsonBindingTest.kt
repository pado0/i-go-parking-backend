package com.igoparking

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.igoparking.adapter.out.vancouver.public.client.dto.ParkingMeterResponse
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonBindingTest {
    @Test
    fun `get parking meters binding test`() {
        val mapper = jacksonObjectMapper()
        val json =
            "{\"total_count\": 4252, \"results\": [{\"meterhead\": \"Pay Station\", \"r_mf_9a_6p\": \"\$1.00\", \"r_mf_6p_10\": \"\$2.00\", \"r_sa_9a_6p\": \"\$1.00\", \"r_sa_6p_10\": \"\$2.00\", \"r_su_9a_6p\": \"\$1.00\", \"r_su_6p_10\": \"\$2.00\", \"rate_misc\": null, \"timeineffe\": \"METER IN EFFECT: 9:00 AM TO 10:00 PM\", \"t_mf_9a_6p\": \"3 Hr\", \"t_mf_6p_10\": \"4 Hr\", \"t_sa_9a_6p\": \"3 Hr\", \"t_sa_6p_10\": \"4 Hr\", \"t_su_9a_6p\": \"3 Hr\", \"t_su_6p_10\": \"4 Hr\", \"time_misc\": null, \"creditcard\": \"Yes\", \"pay_phone\": \"69965\", \"geom\": {\"type\": \"Feature\", \"geometry\": {\"coordinates\": [-123.1299088136328, 49.28501192982684], \"type\": \"Point\"}, \"properties\": {}}, \"geo_local_area\": \"West End\", \"meterid\": \"231216\", \"geo_point_2d\": {\"lon\": -123.1299088136328, \"lat\": 49.28501192982684}}, {\"meterhead\": \"Pay Station\", \"r_mf_9a_6p\": \"\$1.00\", \"r_mf_6p_10\": \"\$1.00\", \"r_sa_9a_6p\": \"\$1.00\", \"r_sa_6p_10\": \"\$1.00\", \"r_su_9a_6p\": \"\$1.00\", \"r_su_6p_10\": \"\$1.00\", \"rate_misc\": null, \"timeineffe\": \"METER IN EFFECT: 9:00 AM TO 10:00 PM\", \"t_mf_9a_6p\": \"3 Hr\", \"t_mf_6p_10\": \"4 Hr\", \"t_sa_9a_6p\": \"3 Hr\", \"t_sa_6p_10\": \"4 Hr\", \"t_su_9a_6p\": \"3 Hr\", \"t_su_6p_10\": \"4 Hr\", \"time_misc\": null, \"creditcard\": \"Yes\", \"pay_phone\": \"69961\", \"geom\": {\"type\": \"Feature\", \"geometry\": {\"coordinates\": [-123.13815208167944, 49.28617565391024], \"type\": \"Point\"}, \"properties\": {}}, \"geo_local_area\": \"West End\", \"meterid\": \"361612\", \"geo_point_2d\": {\"lon\": -123.13815208167944, \"lat\": 49.28617565391024}}, {\"meterhead\": \"Pay Station\", \"r_mf_9a_6p\": \"\$1.00\", \"r_mf_6p_10\": \"\$3.00\", \"r_sa_9a_6p\": \"\$1.00\", \"r_sa_6p_10\": \"\$3.00\", \"r_su_9a_6p\": \"\$1.00\", \"r_su_6p_10\": \"\$3.00\", \"rate_misc\": null, \"timeineffe\": \"METER IN EFFECT: 9:00 AM TO 10:00 PM\", \"t_mf_9a_6p\": \"3 Hr\", \"t_mf_6p_10\": \"4 Hr\", \"t_sa_9a_6p\": \"3 Hr\", \"t_sa_6p_10\": \"4 Hr\", \"t_su_9a_6p\": \"3 Hr\", \"t_su_6p_10\": \"4 Hr\", \"time_misc\": null, \"creditcard\": \"Yes\", \"pay_phone\": \"69987\", \"geom\": {\"type\": \"Feature\", \"geometry\": {\"coordinates\": [-123.1393895448705, 49.29120206217653], \"type\": \"Point\"}, \"properties\": {}}, \"geo_local_area\": \"West End\", \"meterid\": \"231902\", \"geo_point_2d\": {\"lon\": -123.1393895448705, \"lat\": 49.29120206217653}}]}"
        val parkingMeter: ParkingMeterResponse = mapper.readValue(json)

        parkingMeter.total_count shouldBe 4252
    }
}
