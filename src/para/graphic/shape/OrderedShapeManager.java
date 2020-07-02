package para.graphic.shape;
import para.graphic.target.Target;

import java.util.*;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.T;

/** 描画順序をidの順とする図形集合
 */
public class OrderedShapeManager extends ShapeManager {

    public synchronized void add(Shape in) {
        data.add(in);
        Collections.sort((List)data, new Comparator<Shape>() {

            public static final int ASC = 1;   //昇順 (1.2.3....)
            public static final int DESC = -1; //降順 (3.2.1....)

            @Override
            public int compare(Shape o1, Shape o2) {
                int sortType = ASC;
                if (o1 == null && o2 == null) {
                    return 0;
                } else if (o1 == null) {
                    return 1 * sortType;
                } else if (o2 == null) {
                    return -1 * sortType;
                }
                return (o1.id - o2.id) * sortType;
            }
        });
    }
}