package co.guitar.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class PointDeserializer extends StdDeserializer<Point> {

    public PointDeserializer() {
        this(null);
    }

    public PointDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Point deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode coordinates = node.get("coordinates");
        if (coordinates != null && coordinates.isArray() && coordinates.size() == 2) {
            double latitude = coordinates.get("latitude").asDouble();
            double longitude = coordinates.get("longitude").asDouble();
            Coordinate coord = new Coordinate(longitude, latitude); // JTS usa lat, long
            GeometryFactory factory = new GeometryFactory();
            return factory.createPoint(coord);
        }
        return null;
    }
}
