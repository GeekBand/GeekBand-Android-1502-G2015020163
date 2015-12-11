package com.geekband.snap.moran.engine;


import android.util.Log;

import com.geekband.snap.moran.model.ImageItem;
import com.geekband.snap.moran.model.Node;
import com.geekband.snap.moran.util.StreamUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NodeEngine {
    private static final String TAG = "网络请求路径";
    public static List<Node> getNodes(String path,TokenEngine.TokenInfo tokenInfo){
        Map<String,String> params = new HashMap<>();
        params.put("token",tokenInfo.token);
        params.put("user_id",tokenInfo.user_id);
        params.put("distance","500");
        params.put("longitude","121.47749");
        params.put("latitude","31.22516");

        try {
            return doGETRequest(path,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Node> doGETRequest(String path, Map<String, String> params) throws Exception {
        StringBuffer urlBuilder = new StringBuffer(path);
        urlBuilder.append("?");
        for(Map.Entry<String,String> entry : params.entrySet()){
            urlBuilder.append(entry.getKey()).append("=");
            urlBuilder.append(entry.getValue()).append("&");
        }
        urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200){
          return parseJSON(conn.getInputStream());
        }else {
            //TODO
        }
        return null;
    }
    private  static List<Node> parseJSON(InputStream inputStream)throws Exception{
        byte[] is = StreamUtil.readInputStream(inputStream);
        String json = new String(is);

        JSONObject jsonObject = new JSONObject(json);
        JSONObject data = jsonObject.getJSONObject("data");

        List<Node> nodeList = new ArrayList<Node>();
        Iterator iterator = data.keys();

        while (iterator.hasNext()){
            JSONObject nodeJSONObject = data.getJSONObject(iterator.next().toString());
            JSONObject addrJSONObject = nodeJSONObject.getJSONObject("node");
            String addr = addrJSONObject.getString("addr");

            Node node = new Node();
            node.setAddress(addr);
            List<ImageItem> imageItemList = new ArrayList<ImageItem>();
            JSONArray picArrary = nodeJSONObject.getJSONArray("pic");
            for(int i = 0;i< picArrary.length();i++){
                JSONObject picObj = picArrary.getJSONObject(i);
                int picId = picObj.getInt("pic_id");
                String picLink = picObj.getString("pic_link");
                Log.i(TAG,picId + ": " +picLink);

                imageItemList.add(new ImageItem(picId,picLink));
            }
           node.setImages(imageItemList);
           nodeList.add(node);
        }
        return nodeList;
    }

}
