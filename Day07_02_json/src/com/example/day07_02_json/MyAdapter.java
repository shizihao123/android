package com.example.day07_02_json;


import java.util.List;

import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	//private Data data;
	private List<Feed> feeds;
	private Context context;

	public MyAdapter(List<Feed> feeds, Context context) {
		super();
		this.feeds = feeds;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return feeds.size();
	}

	@Override
	public Object getItem(int arg0) {
		return feeds.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		ViewHolder holder = null;
		if(view == null){
			view = LayoutInflater.from(context).inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.image=(ImageView)view.findViewById(R.id.item1);
			holder.category = (TextView)view.findViewById(R.id.category);
			holder.subject = (TextView)view.findViewById(R.id.subject);
			holder.summary = (TextView)view.findViewById(R.id.summary);
			holder.format = (TextView)view.findViewById(R.id.format);
			holder.changed = (TextView)view.findViewById(R.id.changed);
			holder.cover = (TextView)view.findViewById(R.id.cover);

			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}	
		
		holder.category.setText(feeds.get(position).getCategory());
		holder.subject.setText(feeds.get(position).getData().getSubject());
		holder.summary.setText(feeds.get(position).getData().getSummary());
		holder.format.setText(feeds.get(position).getData().getFormat());
		holder.changed.setText(feeds.get(position).getData().getChanged());
		holder.category.setText(feeds.get(position).getCategory());
		holder.cover.setText("http://litchiapi.jstv.com" + feeds.get(position).getData().getCover());

		BitmapUtils utils=new BitmapUtils(context);
		utils.display(holder.image,"http://litchiapi.jstv.com" + feeds.get(position).getData().getCover());
		return view;
	}
	
	class ViewHolder{
		ImageView image;
		TextView subject;
		TextView summary;
		TextView format;
		TextView changed;
		TextView category;
		TextView cover;
	}

}
