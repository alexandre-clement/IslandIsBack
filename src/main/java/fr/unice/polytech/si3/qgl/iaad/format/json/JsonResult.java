package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.format.*;
import fr.unice.polytech.si3.qgl.iaad.resource.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
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

    @Override
    public List<ResourceInformation> getResources()
    {
        List<ResourceInformation> resourceInformation = new ArrayList<>();
        JSONArray jsonArray = extras.getJSONArray(JsonArguments.RESOURCES.toString());
        for (int i = 0; i < jsonArray.length(); i++)
            resourceInformation.add(getResource(jsonArray.getJSONObject(i)));
        return resourceInformation;
    }

    @Override
    public int getAmount()
    {
        return extras.getInt(JsonArguments.AMOUNT.toString());
    }

    private ResourceInformation getResource(JSONObject jsonObject)
    {
        ResourceAmount resourceAmount = ResourceAmount.valueOf(jsonObject.get(JsonArguments.AMOUNT.toString()).toString());
        Resource resource = Resource.valueOf(jsonObject.get(JsonArguments.RESOURCE.toString()).toString());
        ResourceCondition resourceCondition = ResourceCondition.valueOf(jsonObject.get(JsonArguments.COND.toString()).toString());
        return new ResourceInformation(resource, resourceAmount, resourceCondition);
    }
}
