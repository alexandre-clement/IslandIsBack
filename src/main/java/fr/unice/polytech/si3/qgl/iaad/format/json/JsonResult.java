package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Biomes;
import fr.unice.polytech.si3.qgl.iaad.map.Creek;
import fr.unice.polytech.si3.qgl.iaad.map.Found;
import fr.unice.polytech.si3.qgl.iaad.map.Site;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class JsonResult implements Result
{
    private final JSONObject extras;
    private final JSONObject data;

    JsonResult(JSONObject result)
    {
        this.data = result;
        extras = result.getJSONObject(JsonArguments.EXTRAS.toString());
    }

    @Override
    public Integer getCost()
    {
        return data.getInt(JsonArguments.COST.toString());
    }

    @Override
    public Integer getRange()
    {
        return extras.getInt(JsonArguments.RANGE.toString());
    }

    @Override
    public Found getFound()
    {
        return Found.valueOf(extras.get(JsonArguments.FOUND.toString()).toString());
    }

    @Override
    public List<Biomes> getBiomes()
    {
        JSONArray biomes = extras.getJSONArray(JsonArguments.BIOMES.toString());
        return biomes.toList().stream().map(Object::toString).map(Biomes::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<Creek> getCreeks()
    {
        JSONArray creeks = extras.getJSONArray(JsonArguments.CREEKS.toString());
        return creeks.toList().stream().map(Object::toString).map(Creek::new).collect(Collectors.toList());
    }

    @Override
    public List<Site> getSites()
    {
        JSONArray sites = extras.getJSONArray(JsonArguments.SITES.toString());
        return sites.toList().stream().map(Object::toString).map(Site::new).collect(Collectors.toList());
    }
}
