package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(21)
class fi {
    public static Object m11407l(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public static Object m11409m(Object obj) {
        if (obj == null) {
            return null;
        }
        Object transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public static void m11390a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m11395a(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        m11392a(obj, (ArrayList) arrayList);
    }

    private static void m11395a(List<View> list, View view) {
        int size = list.size();
        if (!m11398a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m11398a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean m11398a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static void m11389a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            m11406d(view, rect);
            transition.setEpicenterCallback(new EpicenterCallback() {
                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    public static void m11406d(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public static void m11392a(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        if (transition != null) {
            int transitionCount;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    m11392a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!m11397a(transition) && m11408l(transition.getTargets())) {
                int size = arrayList.size();
                for (transitionCount = 0; transitionCount < size; transitionCount++) {
                    transition.addTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    private static boolean m11397a(Transition transition) {
        return (m11408l(transition.getTargetIds()) && m11408l(transition.getTargetNames()) && m11408l(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m11408l(List list) {
        return list == null || list.isEmpty();
    }

    public static Object m11382a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public static void m11402b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new TransitionListener() {
            public void onTransitionStart(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }
        });
    }

    public static Object m11399b(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().addTransition(transition2).addTransition(transition3).setOrdering(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition3 != null) {
            transition = transition3;
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition4);
        return transitionSet;
    }

    public static void m11386a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static ArrayList<String> m11405d(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        return arrayList2;
    }

    public static void m11384a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String transitionName = view2.getTransitionName();
            arrayList4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName(null);
                String str = (String) map.get(transitionName);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        ((View) arrayList2.get(i2)).setTransitionName(transitionName);
                        break;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        ga.m11502a(view, new Runnable() {
            public void run() {
                for (int i = 0; i < size; i++) {
                    ((View) arrayList5.get(i)).setTransitionName((String) arrayList6.get(i));
                    ((View) arrayList7.get(i)).setTransitionName((String) arrayList4.get(i));
                }
            }
        });
    }

    public static void m11394a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m11394a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void m11396a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m11396a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void m11385a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        ga.m11502a(view, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    String transitionName = view.getTransitionName();
                    if (transitionName != null) {
                        view.setTransitionName(fi.m11383a(map, transitionName));
                    }
                }
            }
        });
    }

    private static String m11383a(Map<String, String> map, String str) {
        for (Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static void m11391a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new TransitionListener() {
            public void onTransitionStart(Transition transition) {
                if (obj5 != null) {
                    fi.m11403b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    fi.m11403b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    fi.m11403b(obj7, arrayList6, null);
                }
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }
        });
    }

    public static void m11393a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.getTargets().clear();
            obj.getTargets().addAll(arrayList2);
            m11403b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public static void m11403b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                m11403b(transitionSet.getTransitionAt(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!m11397a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                transitionCount = arrayList2 == null ? 0 : arrayList2.size();
                for (int i2 = 0; i2 < transitionCount; i2++) {
                    transition.addTarget((View) arrayList2.get(i2));
                }
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void m11401b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public static void m11404c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public static void m11388a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new EpicenterCallback() {
                public Rect onGetEpicenter(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    public static void m11387a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        ga.m11502a(viewGroup, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    view.setTransitionName((String) map.get(view.getTransitionName()));
                }
            }
        });
    }
}
