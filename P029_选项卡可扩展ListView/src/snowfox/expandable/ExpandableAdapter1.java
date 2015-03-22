package snowfox.expandable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//�Զ����ExpandListAdapter
public class ExpandableAdapter1 extends BaseExpandableListAdapter {
	private Context context;
	private SharedPreferences sp;
	private Activity activity;
	// ExpandableListView elv;
	List<Map<String, String>> groups;
	List<List<Map<String, String>>> childs;

	/*
	 * ���캯��: ����1:context���� ����2:һ���б�����Դ ����3:�����б�����Դ
	 */
	public ExpandableAdapter1(Activity activity, Context context,
			List<Map<String, String>> groups,
			List<List<Map<String, String>>> childs) {
		this.groups = groups;
		this.childs = childs;
		this.context = context;
		this.activity = activity;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childs.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	// ��ȡ�����б��View����
	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		@SuppressWarnings("unchecked")
		final String text = ((Map<String, String>) getChild(groupPosition,
				childPosition)).get("child");
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// ��ȡ�����б��Ӧ�Ĳ����ļ�, �������Ԫ��������Ӧ������
		LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(
				R.layout.child, null);
		TextView tv = (TextView) linearLayout.findViewById(R.id.childTo);
		tv.setText(text);
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (groupPosition == 0 && childPosition == 0) {
					// Toast.makeText(context, "���˳���", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 0 && childPosition == 1) {
					// Toast.makeText(context, "������", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();

				}
				if (groupPosition == 0 && childPosition == 2) {
					// Toast.makeText(context, "���˽���", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 0 && childPosition == 3) {
					// Toast.makeText(context, "�ղ�", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 0 && childPosition == 4) {
					// Toast.makeText(context, "����", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 0 && childPosition == 5) {
					// Toast.makeText(context, "����", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 0) {
					// Toast.makeText(context, "��������", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 1) {
					// Toast.makeText(context, "�Ƽ�����", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 2) {
					// Toast.makeText(context, "������", 2).show();
					// ���������汾�Ƿ���Ҫ����
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 3) {
					// Toast.makeText(context, "�������", 2).show();
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 4) {
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
				if (groupPosition == 1 && childPosition == 5) {
					Intent intent = new Intent();
					intent.setClass(context, OtherActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}
			}
		});
		ImageView imageView = (ImageView) linearLayout
				.findViewById(R.id.imageView01);
		imageView.setImageResource(R.drawable.doghouse_logo);

		return linearLayout;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return childs.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	// ��ȡһ���б�View����
	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String text = groups.get(groupPosition).get("group");
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// elv = (ExpandableListView) findViewById(R.id.expandableListView);
		// ��ȡһ���б����ļ�,������ӦԪ������
		LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(
				R.layout.group, null);
		TextView textView = (TextView) linearLayout
				.findViewById(R.id.textView01);
		textView.setText(text);

		return linearLayout;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
